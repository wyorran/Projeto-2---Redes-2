
package newpackage;

public class Forca_protocolo {
   private static int INICIO = 0;
   private static int TENTATIVA = 1;
   private static int DECISAO = 3;
   private String palavravez = "";
   private int npalavra,  dica,  tamanho = 0;
   private int state = INICIO;
   private String[] dicas = {"É professor no curso de Sistemas da FHO.", "Usa óculos.", "Dá aula de Redes.",
       "É uma camada do modelo OSI.", "Representa a relação entre um dispositivo e um meio de transmissão.", "Engloba cabos e adaptadores.",
       "É usado para conectar diferentes redes.", "Recebe pacotes e encaminha para o IP de destino.", "É um equipamento essencial para conexão à internet.",
       "É um dispostivo de segurança da rede.", "Permite ou bloqueia trafegos de informações.", "Pode ser um hardware, software ou ambos.",
       "É um protocolo da camada de transporte.", "Provê a entrega e controle de dados.", "Essencial para conexoes de rede.",
       "É uma camada do modelo OSI.", "Realiza o roteamento de funções.", "Roteadores operam nessa camada.",
       "É um protocolo de comunicação.", "Faz parte da camada de rede.", "A versão mais utilizada atualmente é a 4.",
       "Sistema operacional.", "É um dos mais comuns entre usuários atualmente.", "Sua versão estável é a 10.",
       "Sistema operacional.", "Inspirado no minix.", "Slackware e um exemplo.",
       "Circuito integrado.", "Realiza calculos.", "Pentium e um exemplo."};
   private String[] palavras = {"ORLANDO", "FISICA", "ROTEADOR", "FIREWALL", "TCP", "REDE",
       "IP", "WINDOWS", "LINUX", "PROCESSADOR"};
    /**Retorna mensagens que são enviadas ao cliente, variavel theOutput
    * @param recebe como parametro a entrada do usuário pelo teclado
    * @return theOutput
    */
    public String processInput(String theInput) {
    String theOutput = null;
      if (state == INICIO) {
           npalavra = (int) (Math.random() * 10);//indice da palavra sorteada palavra
           dica = getNpalavra() * 3;
           palavravez = getPalavras()[getNpalavra()]; // palavra cujo indice foi sorteado
           tamanho = getPalavravez().length(); // tamanho da palavra
           theOutput = "Bem vindo ao JOGO DA FORCA. Qual a palavra? DICA: " + getDicas()[dica];
           state = TENTATIVA;
       } else if (state == TENTATIVA) {
           if (theInput.equalsIgnoreCase(getPalavravez())) {
               theOutput = "PARABENS, VOCE ACERTOU! Deseja jogar novamente? (S/N)";
               state = DECISAO;
           } else {
               dica++;
               if ((dica / 3) == getNpalavra()) {
                   theOutput = "Ai vai outra dica: " + getDicas()[dica];
               } else {
                   theOutput = "VOCE FOI ENFORCADO. A palavra era: " + getPalavravez() + ". Quer jogar novamente? (S/N)";
                   state = DECISAO;
               }
           }
       } else if (state == DECISAO) {
           if (theInput.equalsIgnoreCase("S")) {
               theOutput = "PRESSIONE UMA TECLA PARA COMECAR";
               state = INICIO;
           } else {
               theOutput = "TCHAU";
           }
       }
       return theOutput;
   }
   /**Retorna a palavra que deve ser adivinhada
    * @return palavravez
    */
   public String getPalavravez() {
       return palavravez;
   }
   /**Retorna o indice da palavra sorteada
    * @return npalavra
    */
   public int getNpalavra() {
       return npalavra;
   }
   /**Retorna uma dica referente a palavara
    * @return dicas
    */
   public String[] getDicas() {
       return dicas;
   }
   /**Retorna o vetor de palavras
    * @return palavras
    */
   public String[] getPalavras() {
       return palavras;
   }
 }