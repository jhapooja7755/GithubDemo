package files;

import io.restassured.path.json.JsonPath;

public class ComplexJson {

	public static void main(String[] args) {
		JsonPath js = new JsonPath(Payloads.coursePrice());
		int count = js.getInt("courses.size()");
		System.out.println(count);
		int pa = js.getInt("dashboard.purchaseAmount");
		System.out.println(pa);
		String t1 = js.get("courses[2].title");
		System.out.println(t1);
		
		for(int i =0;i<count;i++)
		{
			String allCourseTitle = js.get("courses["+i+"].title");
			
			//System.out.println(allCourseTitle);
			//System.out.println(js.get("courses["+i+"].price").toString());
			if(allCourseTitle.equalsIgnoreCase("Appium"))
			{
				System.out.println(js.get("courses["+i+"].copies").toString());
				break;
			}
		}

	}

}
