package hac;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URL;
import static hac.Macros.*;

/**
 * Name: Batya pollack
 * EX2
 *title: Servlet ShowSurveyServlet -  The program start with this servlet and to this func there is func "INIT"
 * that reads data from file and insert them to a global array and is there is exceptions she catch them
 */
@WebServlet(name = "ShowSurveyServlet", urlPatterns = "/ShowSurveyServlet",
        initParams = {
                @WebInitParam(name = "fileName", value = FILE_NAME)})
public class ShowSurveyServlet extends HttpServlet
{
    /**
     *  function that reads data from file and insert them to a global array and is there is exceptions she catch them
     * @param config - type ServletConfig
     * @throws ServletException - Exception that indicate Fail of ServletException
     */
    @Override
    public void init(ServletConfig config) throws ServletException
    {
        super.init(config);
        ArraySavedResults arraySavedResults = ArraySavedResults.getInstance();
        config.getServletContext().setAttribute("Error", true);
        String fileName = config.getInitParameter("fileName");
        BufferedReader file = null;
        try{
            readFromFileIfValid(config,fileName,arraySavedResults,file);
        }
        catch (IOException e) {
            System.err.println(e.toString());
            config.getServletContext().setAttribute("Error", false);
        }
        finally {
            try {
                if(file!=null)
                {
                    file.close();
                }
            }
            catch (IOException e) {
                System.err.println(FAIL_CLOSE_FILE);
            }
        }
    }

    /**
     * function that read from file and check if url of file is valid and save the array of all results in context
     * @param config - type ServletConfig
     * @param fileName - String of file name
     * @param arraySavedResults - array of all results
     * @param file - type BufferedReader
     * @throws IOException - Exception that indicate to fail
     */
    private void readFromFileIfValid(ServletConfig config, String fileName, ArraySavedResults arraySavedResults, BufferedReader file) throws IOException {
        file =  checkIfFileValid(config, fileName);
        readFromFile(config, file, arraySavedResults);
        config.getServletContext().setAttribute("ListOfFile", arraySavedResults);
    }

    /**
     * function that read from file
     * @param config- type ServletConfig
     * @param file -  String of file name
     * @param arraySavedResults- array of all results
     * @throws IOException - Exception that indicate to fail
     */
    private void readFromFile(ServletConfig config, BufferedReader file, ArraySavedResults arraySavedResults) throws IOException {

        String s ;
        if ((s = file.readLine()) != null)//q
        {
            config.getServletContext().setAttribute("Question", s);
            while ((s = file.readLine()) != null)//a
            {
                arraySavedResults.addIndex(new PairOfAnswerCount.AnswerAndCount(s, ZERO));
            }
        }
    }

    /**
     * function that check if url is valid and return the file
     * @param config - type ServletConfig
     * @param fileName - file
     * @return file from type BufferedReader
     * @throws IOException - Exception that indicate to fail
     */
    private BufferedReader checkIfFileValid(ServletConfig config, String fileName) throws IOException
    {
        URL url =  config.getServletContext().getResource(fileName);
        if(url == null)
            throw  new IOException();
        return new BufferedReader(new InputStreamReader(url.openStream()));
    }

    /**
     * handles the form and display a welcome message.
     * In case no input is given it sends back the form.
     * @param request - request from  client
     * @param response- response to client
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    {
        try {

            if (request.getQueryString() != null)
                request.getRequestDispatcher("/ErrorUrlGet.html").include(request, response);
            buildForm(request, response);
        }
        catch (ServletException | IOException e)
        {
            try {
                request.getRequestDispatcher("/ErrorConnect.html").include(request, response);
            }
            catch (IOException | ServletException e1) {System.err.println(ERROR_CONNECTION);}
        }
    }

    /**
     * function that build form for client
     * @param request - request from client
     * @param response - response to client
     * @throws IOException - Exception that indicate to fail from type IOException
     * @throws ServletException - Exception that indicate to fail from type ServletException
     */
    private void buildForm(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter = response.getWriter();
        request.getRequestDispatcher("/StartPage.html").include(request, response);
        printWriter.println(" <h5>" + getServletContext().getAttribute("Question") + "</h5> <hr style = width:50%>");
        printWriter.println(" <form method=\"POST\" action=\"ResultsServlet\">");
        ArraySavedResults arraySavedResults;
        arraySavedResults = (ArraySavedResults) getServletContext().getAttribute("ListOfFile");
        for (int i = 0; i < arraySavedResults.getSizeList(); ++i) {
            printWriter.println("<input type=\"radio\" name = item value =" + i + ">" + arraySavedResults.getAnswerByIndex(i) + "</radio><br/>");
        }
        printWriter.println(" <BR><BR><input type=\"submit\" name = btnSubmit value= Send>" + "</form> </body></html>");
        printWriter.close();
    }

    /**
     * function that check if url is valid , if size of rows small than 3 , if all valid- read to function doPost
     * just return a form
     * @param request the request
     * @param response the response
     * @throws IOException - Exception that indicate to fail from type IOException
     * @throws ServletException - Exception that indicate to fail from type ServletException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String url = request.getRequestURI();
        if(!(url.equals("/ShowSurveyServlet") || url.equals("/ResultsServlet")))
            return;
        if(!UrlValid(request,response) || !sizeRowsValid(request,response))
            return;
        doPost(request,response);
    }

    /**
     * function that check if size rows of file is valid, if so - return true , else- false.
     * @param request - request from client
     * @param response -response to client
     * @return boolean true if size Rows Valid
     * @throws IOException - Exception that indicate to fail from type IOException
     * @throws ServletException - Exception that indicate to fail from type ServletException
     */
    private boolean sizeRowsValid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArraySavedResults list = (ArraySavedResults) getServletContext().getAttribute("ListOfFile");
        if ((!(Boolean) getServletContext().getAttribute("Error")) || (list.getSizeList() < SIZE_ROWS) )
        {
            request.getRequestDispatcher("/ErrorSizeRows.html").include(request, response);
            return false;
        }
        return true;
    }

    /**
     * function that check if url is valid if so - return true , else- false.
     * @param request - request fron client
     * @param response - response to client
     * @return boolean true if url is valid
     * @throws IOException - Exception that indicate to fail from type IOException
     * @throws ServletException - Exception that indicate to fail from type ServletException
     */
    private boolean UrlValid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getQueryString() != null) {
            request.getRequestDispatcher("/ErrorUrlGet.html").include(request, response);
            return false;
        }
        return true;
    }
}
