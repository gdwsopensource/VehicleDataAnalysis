(function($){
	var url = location.search; //获取url中"?"符后的字串 
	if(url){
		$('#data').find('.box').find('.search').css('display','none');
		var QueryObj = new Object(); 
		var str = url.substr(1); 
		strs = str.split("&"); 
		for(var i = 0; i < strs.length; i ++) { 
			QueryObj[strs[i].split("=")[0]]=unescape(strs[i].split("=")[1]); 
		}
		console.log(QueryObj);
		/*var type=0;
		getAnalysisData(QueryObj,type,function(data){
			var data=JSON.parse(data);
			console.log(data);
			if(data.code === 200){
				if(data.data === "no data"){
					$('#data').find('.box').find('.result').html('没有查询到结果~');
				}else{
					
				}
			}
		});*/		
	}else{		
		$('#search_btn').on('click',function(){
			var searchVal=$('#search').val(); //搜索输入的值
			//var nowDate=new Date().getNowFormatDate(); //当前时间
			var nowDate="2016-06-01";
			getAnalysisData({"plateNo":searchVal,"crossTime":nowDate},7,"cb");
		});
		$("#time_s").find("input[type='radio']").on('change',function(){
			
		});
		
	}
	function getAnalysisData(QueryObj,type,callback){
		var plateNo=QueryObj.plateNo || "",crossTime=QueryObj.crossTime || "",day=QueryObj.day || "";
		//debugger;
		if(type == 0){ // 一天
			$.ajax({  
		        type: "get",  
		        async: false,  
		        url: "http://localhost:8082/analysisOnHour?plateNo="+plateNo+"&crossTime="+crossTime,  
		        dataType: "jsonp",  
		        jsonp:"cb",
		        success:function(data){
		        	console.log(data);
		        	callback && callback(data);
		        },
		        error:function(err){
		        	  console.log("请求出错----"+err);
		        }
			});
		}else if(type ==1){ // 一周   //一月
			$.ajax({  
		        type: "get",  
		        async: false,  
		        url: "http://localhost:8082/analysisOnWeek?day="+day+"&plateNo="+plateNo,  
		        dataType: "jsonp",  
		        jsonp:"cb",
		        success:function(data){
		        	callback && callback(data);
		        },
		        error:function(err){
		        	  console.log("请求出错----"+err);
		        }
			});
		}else if(type == 2){			//一年
			$.ajax({  
		        type: "get",  
		        async: false,  
		        url: "http://localhost:8082/analysisOnYear?plateNo="+plateNo,  
		        dataType: "jsonp",  
		        jsonp:"cb",
		        success:function(data){
		        	callback && callback(data);
		        },
		        error:function(err){
		        	  console.log("请求出错----"+err);
		        }
			});
		}
	}
})(jQuery);