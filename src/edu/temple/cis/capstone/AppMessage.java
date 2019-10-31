package edu.temple.cis.capstone;

import org.json.JSONException;
import org.json.JSONObject;


/**
 * This class is used to communicate between the BinBot mobile application and the server. It is used for both alerting
 * the Server to stop operation and for sending images to display to the app. It is sent as a json string in the format
 * {
 *     "poweredState":<Boolean>,
 *     "img":<String>
 * }
 * where poweredState is true when the system should continue operation and the img is a BufferedImage converted into
 * a string which will be displayed in the mobile application.
 *
 * @author Sean DiGirolamo
 * @since 2019-10-29
 */
public class AppMessage
{
	private Boolean poweredState;
	private String img = null;

	/**
	 * This constructor takes as input a json string. It assumes that the json is properly formatted in the proper
	 * configuration and results in an AppMessage object based on the json string provided.
	 *
	 * @author Sean DiGirolamo
	 * @since 2019-10-29
	 */
	public AppMessage(String json) {
		JSONObject jsonObject;
		try {
			jsonObject = new JSONObject(json);
			this.poweredState = jsonObject.getBoolean("poweredState");
			this.img = jsonObject.getString("img");
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method creates a new immutable AppMessage object based on the arguments provided.
	 *
	 * @author Sean DiGirolamo
	 * @since 2019-10-29
	 */
	public AppMessage(Boolean poweredState, String img) {
		this.poweredState = poweredState;
		this.img = img;
	}

	/**
	 * This method returns the AppMessage class a a json string which can be sent to the BinBot Mobile Application.
	 *
	 * @author Sean DiGirolamo
	 * @since 2019-10-29
	 */
	public String json() {
		StringBuilder retval = new StringBuilder("{\"poweredState\":")
			.append(this.poweredState.toString())
			.append(",")
			.append("\"img\":" + "\"");

		if (this.img != null) {
			retval.append(img);
		}

		retval.append("}");

		return retval.toString();
	}

	/**
	 * This method returns the value of the poweredState boolean contained within the AppMessage
	 *
	 * @author Sean DiGirolamo
	 * @since 2019-10-29
	 */
	public Boolean poweredState() {
		return this.poweredState;
	}

	/**
	 * This method returns the Buffered img contained within the AppMessage
	 *
	 * @author Sean DiGirolamo
	 * @since 2019-10-21
	 */
	public String img() {
		return this.img;
	}
}
