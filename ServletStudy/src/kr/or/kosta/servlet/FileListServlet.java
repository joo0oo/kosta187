package kr.or.kosta.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;

/**
 * 파일 리스트 처리 서블릿
 */
public class FileListServlet extends HttpServlet {
	
	private String fileRepository;
	
	@Override
	public void init() throws ServletException {
		fileRepository = getServletContext().getInitParameter("Location");
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		process(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		process(request, response);
	}
	
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<FileItem> fileList = null; //파일 여러개일 경우 대비해서 list로 받기
		
		File fPath= new File(fileRepository);
		File[] files= fPath.listFiles();
		
		printHtml(request, response, files);
	
	}
	
	public void printHtml(HttpServletRequest request, HttpServletResponse response, File[] files) throws IOException, ServletException {
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		int fileNum= 1;
		String jscript= "<script type=\"text/javascript\">\r\n" + 
			            "function download(fileName) {\r\n" + 
			            "   location.href=\"/servlet/download.do?file=\"+fileName;\r\n" + 
			            "}\r\n" + 
			            "\r\n" + 
			            "</script>";
		
		out.println("<html>");
		out.println("<head>");
		//out.println(jscript);
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>파일 리스트</h2>");
		
		out.println("<table border='1'>");
		out.println("<tr>");
		out.println("<th> 번호 </th>");
		out.println("<th> 파일명 </th>");
		out.println("<th> 사이즈 </th>");
		out.println("<th> 다운로드 </th>");
		out.println("</tr>");
		
		/*
		for (File file : files) {
			out.println("<tr>");
			out.println("<td> "+fileNum+" </td>");
			out.println("<td> <p id=\"fileName\" name=\"fileName\">"+file.getName()+"</p> </td>");
			out.println("<td> "+file.length()+" </td>");
			//request.setAttribute("fileName", file.getName());
			//request.getRequestDispatcher("/download.do").forward(request, response);

			//request.setAttribute("file", file);
			out.println("<td> "+
						" <button onclick=\"location='download.do?file=\""+ file.getName() +
						"\"'>download</button>"+
						" </td>");
			
			out.println("</tr>");
			fileNum++;
		}
		*/
		for(int i=0; i<files.length; i++) {
			out.println("<tr>");
			out.println("<td> "+(i+1)+" </td>");
			out.println("<td> "+files[i].getName()+" </td>");
			out.println("<td> "+files[i].length()+" </td>");
			out.println("<td> "+
//						"<button onclick=\\\"location.href='download.do?file="+files[i].getName()+"'; \\\"> download </button>"+
						"<button onclick=\"location.href='download.do?file="+files[i].getName()+"'; \"> download </button>"+
						" </td>");
			out.println("</tr>");
		}
		out.println("</table>");
		
		out.println("</body>");
		out.println("</html>");
	}
	
	public void fileDownload(HttpServletRequest request, HttpServletResponse response, File file) throws IOException {
		String fileName = file.getName();
		if (fileName == null || fileName.equals(""))
			return;

		String filePath = fileRepository + fileName;
		
		
		// HTTP 버전별 브라우저 캐시 사용 않도록 응답헤더 설정
		String httpVersion = request.getProtocol();
		if (httpVersion.equals("HTTP/1.0")) { //http 버전에 따른 처리 
			response.setDateHeader("Expires", 0);
			response.setHeader("Pragma", "no-cache");
		} else if (httpVersion.equals("HTTP/1.1")) {
			response.setHeader("Cache-Control", "no-cache");
		}
		
		// 파일 다운로드 처리를 위한 응답헤더에 마임타입 설정
		response.setContentType("application/octet-stream");
		fileName = URLEncoder.encode(fileName, "utf-8"); //한글 파일명인 경우 처리 
		response.setHeader("Content-Disposition", "attachment;filename=" + fileName + ";");
		response.setHeader("Content-Length", "" + file.length());

		FileInputStream in = new FileInputStream(file);
		OutputStream out = response.getOutputStream();
		try{
			byte[] buffer = new byte[1024];
			int count = 0;
			while ((count = in.read(buffer)) != -1) {
				out.write(buffer, 0, count);
			}
		}finally{
			if(out != null) out.close();
			if(in != null)  in.close();
		}
	}
}
