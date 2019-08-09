# 可以集成第三方的API接口服务，方便配置自动化联动与快速的响应处理    

- 调用示例1:
    
```  

RequestClient client = new RequestClient();//声明请求构造器  
client.url($url).method($method).contentType($contentType);//设置参数  
if (4 == $contentType) {//如果content-type为raw,则需指定数据与格式  
  body.set($rawFormat, $rawBody);  
}   
RequestHeader header = new RequestHeader();   
header.add("key", $value);//添加请求头信息   
header.add("key", $value);//添加请求头信息    

```  

RequestBody body = new RequestBody();  
//请求数据有以下三种情况   
body.add("key", $value);//1.添加文本类数据   
body.addFile("key","fileName",$value); //2.添加文件数据   
body.set($rawFormat, $rawBody); //3.添加 content-type:raw 情况下的,数据与格式   
... ...   
  
client.send(header, body);//请求数据  

```  


调用示例2:  
  
```  

RequestClient client = new RequestClient();//声明请求构造器  
RequestHeader header = new RequestHeader();   
RequestBody body = new RequestBody();  
RequestAuthorization auth = new RequestAuthorization();  
  
client.url($url).method($method).contentType($contentType).setHeader(header).setBody(body).setAuth(auth);//请求数据  
client.send();  

```  

调用示例3: 

```   
...  ...  
client.send(new Callback() {  
	@Override  
	public void onResponse(Call call, Response response) throws IOException {  
		// TODO Auto-generated method stub  
	}  
	@Override  
	public void onFailure(Call call, IOException e) {  
		// TODO Auto-generated method stub  
    }  
});  

```  