package webserviceUTIL;

	import org.ksoap2.SoapEnvelope;
	import org.ksoap2.serialization.SoapObject;
	import org.ksoap2.serialization.SoapPrimitive;
	import org.ksoap2.serialization.SoapSerializationEnvelope;
	import org.ksoap2.transport.HttpTransportSE;

	public class Tienich {
	   private static String methodCheckLogin = "checkLoginS";
	   private static String methodGetLisCategory = "getListCategoryS";
	   private static String methodGetListStory = "getListStoryS";
	   private static String methodGetStory = "getStoryS";

	   private static String NAMESPACE = "http://webservice/";
	   private static String actionCheckLogin = NAMESPACE + "/" + methodCheckLogin;
	   private static String actionGetListCategory = NAMESPACE + "/" + methodGetLisCategory;
	   private static String actionGetListStory = NAMESPACE + "/" + methodGetListStory;
	   private static String actionGetStory = NAMESPACE + "/" + methodGetStory;

	   private static final String URL = "http://192.168.194.57:8084/WebServiceStory/StoryWebService?wsdl";

	   public boolean checkLogin(String username, String password) {
		   SoapObject request = new SoapObject(NAMESPACE, methodCheckLogin);
		   request.addProperty("username", username); 
		   request.addProperty("password", password); 
		   SoapSerializationEnvelope envelope = new
				   SoapSerializationEnvelope(SoapEnvelope.VER11); 
		   envelope.setOutputSoapObject(request); 

		   HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

           try {
			androidHttpTransport.call(actionCheckLogin, envelope);
			 SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
			 if (response.toString().equals("true"))
				 return true;
			 else 
				 return false;
			 
			} catch (Exception e) {
				// TODO Auto-generated catch block
				return false;
			} 
	     
	   }
	   
	   public String getListCategory() {
		   SoapObject request = new SoapObject(NAMESPACE, methodGetLisCategory);		 
		   SoapSerializationEnvelope envelope = new
				   SoapSerializationEnvelope(SoapEnvelope.VER11); 
		   envelope.setOutputSoapObject(request); 

		   HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

           try {
			androidHttpTransport.call(actionGetListCategory, envelope);
			 SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
			 return response.toString();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				return e.toString();
			} 
	     
	   }
	   
	   public String getListStory(String idCategory) {
		   SoapObject request = new SoapObject(NAMESPACE, methodGetListStory);
		   request.addProperty("idCategory", idCategory); 		  
		   SoapSerializationEnvelope envelope = new
				   SoapSerializationEnvelope(SoapEnvelope.VER11); 
		   envelope.setOutputSoapObject(request); 

		   HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

           try {
        	   androidHttpTransport.call(actionGetListStory, envelope);
        	   SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
			   return response.toString();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				return e.toString();
			} 
	     
	   }
	   
	   public String getStory(String idStory) {
		   SoapObject request = new SoapObject(NAMESPACE, methodGetStory);
		   request.addProperty("idStory", idStory); 		  
		   SoapSerializationEnvelope envelope = new
				   SoapSerializationEnvelope(SoapEnvelope.VER11); 
		   envelope.setOutputSoapObject(request); 

		   HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

           try {
        	   androidHttpTransport.call(actionGetStory, envelope);
        	   SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
			   return response.toString();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				return e.toString();
			} 
	     
	   }
	   
	   
}
