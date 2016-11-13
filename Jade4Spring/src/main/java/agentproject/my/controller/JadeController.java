package agentproject.my.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.android.gcm.server.InvalidRequestException;
import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.Result;
import com.google.android.gcm.server.Sender;

@Controller
@RequestMapping(value = "/")
public class JadeController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	 @ResponseBody
	public String test(){
		
		return "Hello World";
	}
	
	 public boolean pushNotificationToGCM(String gcmRegId,String message){
	        final String GCM_API_KEY = "AIzaSyDr18Fd-Uf_1mp6TEId5NTNIC4XNnbNWJw";
	        final int retries = 3;
	        Sender sender = new Sender(GCM_API_KEY);
	        Message msg = new Message.Builder().addData("message",message).build();

	        try {
	            
	                Result result = sender.send(msg, gcmRegId, retries);
	                /**
	                * if you want to send to multiple then use below method
	                * send(Message message, List<String> regIds, int retries)
	                **/
	            

	                if (StringUtils.isEmpty(result.getErrorCodeName())) {
	                    System.out.println("GCM Notification is sent successfully" + result.toString());
	                    return true;
	                }

	                System.out.println("Error occurred while sending push notification :" + result.getErrorCodeName());

	           
	        } catch (InvalidRequestException e) {
	            System.out.println("Invalid Request");
	        } catch (IOException e) {
	            System.out.println("IO Exception");
	        }
	        return false;

	    }
	 
     public static void main(String args[]){
    	 JadeController j=new JadeController();
    	 j.pushNotificationToGCM("APA91bHqSTd323GZxbpwPC0Lbdm6jsXRLECj8dgYGe9Jmm5tTNljMD-ft5H7H0fehIwFGrdk3BSiPK2Cu8MHnobv8jO2IZcjvjkc-2rlpFR9fqfTBIJPlOBtYfWR3Zgko8wyDGMUBCYh", "Hellow push notification");
     }
}
