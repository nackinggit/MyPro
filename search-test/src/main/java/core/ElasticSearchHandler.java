package core;

import java.util.ArrayList;
import java.util.List;

import org.elasticsearch.action.index.IndexRequestBuilder;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;

import entity.DataFactory;
import entity.Medicine;

public class ElasticSearchHandler {
	private Client client;
	
	public ElasticSearchHandler() {
		this("127.0.0.1");
	}
	
	public ElasticSearchHandler(String s) {
		client = new TransportClient().addTransportAddress(new InetSocketTransportAddress(s, 9300));
	}
	
	public void createIndexResponse(String indexName, String type, List<String> jsons) {
		IndexRequestBuilder requestBuilder = client.prepareIndex(indexName, type).setRefresh(true);
		
		for(int i=0; i<jsons.size(); i++) {
			requestBuilder.setSource(jsons.get(i)).execute().actionGet();
		}
	}
	
	 /**
     * 创建索引
     * @param client
     * @param jsondata
     * @return
     */
    public IndexResponse createIndexResponse(String indexname, String type,String jsondata){
        IndexResponse response = client.prepareIndex(indexname, type)
            .setSource(jsondata)
            .execute()
            .actionGet();
        return response;
    }
    
    public List<Medicine> search(QueryBuilder queryBuilder, String indexName, String type) {
    	List<Medicine> list = new ArrayList<Medicine>();
    	SearchResponse searchResponse = client.prepareSearch(indexName).setTypes(type)
    			.setQuery(queryBuilder)
    			.execute().actionGet();
    	
    	SearchHits hits = searchResponse.getHits();
    	System.out.println("查询到记录数=" + hits.getTotalHits());
    	
    	SearchHit[] searchHits = hits.getHits();
    	
    	if(searchHits.length > 0) {
    		for(SearchHit hit: searchHits){
                Integer id = (Integer)hit.getSource().get("id");
                String name =  (String) hit.getSource().get("name");
                String function =  (String) hit.getSource().get("function");
                list.add(new Medicine(id, name, function));
            }
    	}
    	
    	return list;
    }
    
    public void clearAlldata() {
    	client.prepareDeleteByQuery("indexdemo").setTypes("typedemo").setQuery(QueryBuilders.matchAllQuery()).execute().actionGet();
    	System.out.println("数据清空完毕.");
    }
    
    public static void main(String[] args) {
        ElasticSearchHandler esHandler = new ElasticSearchHandler();
        esHandler.clearAlldata();
       /* List<String> jsondata = DataFactory.getInitJsonData();
        String indexname = "indexdemo";
        String type = "typedemo";
        esHandler.createIndexResponse(indexname, type, jsondata);
        //查询条件
        QueryBuilder queryBuilder = QueryBuilders.commonTerms("name", "感冒");
        QueryBuilder queryBuilder = QueryBuilders.boolQuery()
          .must(QueryBuilders.termQuery("id", 1));
        List<Medicine> result = esHandler.search(queryBuilder, indexname, type);
        for(int i=0; i<result.size(); i++){
            Medicine medicine = result.get(i);
            System.out.println("(" + medicine.getId() + ")药品名称:" +medicine.getName() + "\t\t" + medicine.getFunction());
        }*/
    }
}
