

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


/**
 * Servlet implementation class ClientReq
 */
@WebServlet("/ClientReq")
public class ClientReq extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ClientReq() {
        // TODO Auto-generated constructor stub
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		URL url=new URL("http://10.51.6.233:8080/Server/DataServer");//http://10.51.5.176:port/Server/DataServer
		HttpURLConnection con=(HttpURLConnection)url.openConnection();
		con.setRequestMethod("GET");
		if(con.getResponseCode()==200)
		{
			System.out.println("request received");
			BufferedReader br=new BufferedReader(new InputStreamReader(con.getInputStream()));
			String json=br.readLine();
			System.out.print(json);
			JSONParser parser = new JSONParser();
			JSONObject jo;
			try {
				jo = (JSONObject) parser.parse(json);
				request.setAttribute("jsonObject", jo);
				request.getRequestDispatcher("/response.jsp").forward(request, response);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		else
		{
			System.out.println("not received");
		}
		
	}

}
