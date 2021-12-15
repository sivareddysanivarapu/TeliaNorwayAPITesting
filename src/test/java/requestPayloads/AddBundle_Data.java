package requestPayloads;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import addBundle.addBundleRequest;
import addBundle.properties;
import testData.TestData;

public class AddBundle_Data extends TestData{
	
	public static addBundleRequest inputRequestPayload(String testCase, String ...preData ) {
		
		properties p = new properties();
		p.setValidTo(null);
		if(preData[0].contentEquals("with"))
			p.setValidTo(dateTime());
			
		addBundleRequest input = new addBundleRequest();
		input.setProperties(p);
		
		if(testCase == "TC214")
			input.setBundleCode(bundleCode);
		else if(testCase == "TC216")
			input.setBundleCode(roamingBundleCode);
		else if(testCase == "TC217")
			input.setBundleCode(addOnBundleCode);
		else if(testCase == "TC226")
			input.setBundleCode(RCCBundleCode);
		else if(testCase == "TC227")
			input.setBundleCode(topupBundleCode);
		else if(testCase == "TC228")
			input.setBundleCode(invalidCode);
		else
			input.setBundleCode(null);
		
		return input;
	}
	
	public static String dateTime () {
		Calendar dNow = Calendar.getInstance();
		dNow.setTime(new Date());
		dNow.add(Calendar.DATE, 30); 
		SimpleDateFormat ft1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat ft2 = new SimpleDateFormat("HH:mm:ss");
		String datetime = ft1.format(dNow.getTime()) + "T" + ft2.format(dNow.getTime()) + "Z";
		return datetime;
	}
		
}
