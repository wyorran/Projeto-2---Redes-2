
package newpackage;

import java.net.*;
import java.io.*;

 public class Servidor {
 /**Método Main.
 * @param args
 * @exception IOException
*/
 public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
       try {
            serverSocket = new ServerSocket(8080);
       } catch (IOException e) {
           System.err.println("Nao foi possivel abrir a porta: 8080.");
           System.exit(1);
       }
        Socket clientSocket = null;
       try {
            clientSocket = serverSocket.accept();
       } catch (IOException e) {
           System.err.println("Socket nao aceito.");
           System.exit(1);
       }
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
       BufferedReader in = new BufferedReader(
               new InputStreamReader(
               clientSocket.getInputStream()));
       String inputLine, outputLine;
       Forca_protocolo forcaprot = new Forca_protocolo();
       outputLine = forcaprot.processInput(null);
       out.println(outputLine);
       while ((inputLine = in.readLine()) != null) {
           outputLine = forcaprot.processInput(inputLine);
           out.println(outputLine);
           if (outputLine.equals("TCHAU")) {
               break;
           }
        }
 /**Método responsável por fechar a instancia da classe PrintWriter ao final da execução
 */
        out.close();
/**Método responsável por fechar a instancia da classe BufferedReader ao final da execução
*/
        in.close();
/**Método responsável por fechar a instancia da classe Socket ao final da execução
*/
        clientSocket.close();
/**Método responsável por fechar a instancia da classe ServerSocket ao final da execução
*/
        serverSocket.close();
   }
 }