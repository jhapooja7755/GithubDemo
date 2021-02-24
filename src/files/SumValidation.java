package files;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class SumValidation {

	@Test
	public void sum()
	{
		int sum = 0;
		JsonPath js = new JsonPath(Payloads.coursePrice());
		int count = js.getInt("courses.size()");
		for(int i =0;i<count;i++)
		{
			int price = js.getInt("courses["+i+"].price");
			int copies = js.getInt("courses["+i+"].copies");
			int total = price*copies;
			System.out.println(total);
			sum = sum +total;
			System.out.println(sum);
		}
		System.out.println(sum);
		int purchaseAmt = js.getInt("dashboard.purchaseAmount");
		Assert.assertEquals(sum, purchaseAmt);
	}
	
}
