package candidatura;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;

public class ProcessoSeletivo {
    public static void main (String [] args){
        
       // selecaoCandidatos();
       // imprimirSelecionados();

        String [] candidatos = {"Felipe","Marcia","Julia","Paulo","Augusto"};
        for (String candidato: candidatos) {
            entrandoEmContato(candidato);
        }
    }
        static void entrandoEmContato(String candidato) {
            int tentativasRealizadas = 1;
            boolean continuarTentando = true;
            boolean atendeu = false;
            do {
                atendeu = atender();
                continuarTentando = !atendeu;
                if (continuarTentando)
                    tentativasRealizadas++;
                else 
                System.out.println("Contato realizado com sucesso!");

               
            }while (continuarTentando && tentativasRealizadas < 3);
            if (atendeu)
            System.out.println("Conseguimos contato com "+ candidato + " na " + tentativasRealizadas + "° tentativa");
            else 
            System.out.println("Não conseguimos contato com " + candidato + " ,número máximo de tentativas = "+ tentativasRealizadas + " realizadas");
        }

        static boolean atender(){
            return new Random().nextInt(3) == 1;
        }

    static void imprimirSelecionados(){

        String [] candidatos = {"Felipe","Márcia","Julia","Paulo","Augusto"};
        System.out.println("Lista de Candidatos Selecionados:\n");
        for(int indice = 0; indice <candidatos.length;indice++){
            System.out.println("O candidato de n° " + (indice+1) + " é " + candidatos[indice]);

        }

    }

    static void selecaoCandidatos(){

       String [] candidatos = {"Felipe","Marcia","Julia","Paulo","Augusto","Monica","Fabricio","Mirela","Daniela","Jorge"};
       int candidatosSelecionados = 0;
       int candidatoAtual = 0;
       double salarioBase = 2000.0;
       
       while(candidatosSelecionados < 5 && candidatoAtual< candidatos.length){
            String candidato = candidatos [candidatoAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato " + candidato + " Solicitou este valor de salário:\nR$ " + salarioPretendido);
            if(salarioBase >= salarioPretendido){
                System.out.println("O candidato " + candidato + " foi selecionado para a vaga\n");
                candidatosSelecionados++;

            }
            candidatoAtual++;
       }
    }

    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800,2200);
    }

    
    static void analisarCandidato(double salarioPretendido) {
        double salarioBase = 2000.0;
        if (salarioBase > salarioPretendido){
        System.out.println("LIGAR PARA O CANDIDATO");

     }else if (salarioBase == salarioPretendido)
        System.out.println("LIGAR PARA O CANDIDATO COM CONTRA-PROPOSTA");
     else {
        System.out.println("AGUARDANDO O RESULTADO DOS DEMAIS CANDIDATOS");

     }

    }

}
