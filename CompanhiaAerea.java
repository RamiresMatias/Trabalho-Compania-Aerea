package companhiaaerea;

import java.util.Scanner;

public class CompanhiaAerea {
  static Scanner input = new Scanner(System.in);
  static Voo voos[] = new Voo[10];  
  
  public static void main(String[] args) {
    exibirMenu(); // exibe o menu de opções    
  }  
  
  public static void exibirMenu(){
    while(true){
      System.out.println("1. Cadastrar Voo");
      System.out.println("2. Listar Voos");
      System.out.println("3. Efetuar Reserva");
      System.out.println("4. Listar Reservas Por Voo");
      System.out.println("5. Sair");
      System.out.print("Sua opção: ");
      int opcao = Integer.parseInt(input.nextLine());
      
      switch(opcao){
        case 1:
          cadastrarVoo();
          break;
        case 2:
          listarVoos();
          break;
        case 3:
          efetuarReserva();
          break;
        case 4:
          listarReservas();
          break;  
        case 5:
          System.out.println("\nSaindo do sistema...\n");
          System.exit(0);
          break;
      }
    }
  }
  
  public static void cadastrarVoo(){
    boolean sucesso = false;
    for(int i = 0; i < voos.length; i++){
      if(voos[i] == null){
        System.out.println("\nCADASTRAR NOVO VOO...\n");
        System.out.print("Número do voo: ");
        int numero = Integer.parseInt(input.nextLine());
        System.out.print("Origem: ");
        String origem = input.nextLine();
        System.out.print("Destino: ");
        String destino = input.nextLine();
        System.out.print("Horário: ");
        String horario = input.nextLine();
        System.out.print("Quantidade de assentos: ");
        int quantAssentos = Integer.parseInt(input.nextLine());
        voos[i] = new Voo(numero, origem, destino, horario,
          quantAssentos);
        System.out.println("\nVoo cadastrado com sucesso.\n");
        sucesso = true;
        break;
      }   
    }
    
    if(!sucesso){
      System.out.println("\nVetor de voos está cheio.\n");  
    }
  }
  
  public static void listarVoos(){
    System.out.println("\nLISTANDO OS VOOS...\n");
    for(int i = 0; i < voos.length; i++){
      if(voos[i] != null){
        System.out.println("Número: " + voos[i].getNumero());
        System.out.println("Origem: " + voos[i].getOrigem());
        System.out.println("Destino: " + voos[i].getDestino());
        System.out.println("Horário: " + voos[i].getHorario());
        System.out.println("Quant. Assentos: " + 
          voos[i].getAssentos().length + "\n");
      }  
    }
  }
  
  public static void efetuarReserva(){
    System.out.print("\nInforme o voo: ");
    int numero = Integer.parseInt(input.nextLine());
    boolean encontrado = false; // para informar se o voo foi encontrado
    
    for(int i = 0; i < voos.length; i++){
      if((voos[i] != null) && (voos[i].getNumero() == numero)){ // o voo foi encontrado?
        encontrado = true;
        System.out.print("Informe o assento desejado: ");
        int assento = Integer.parseInt(input.nextLine());
        // o assento informado está dentro da faixa permitida?
        if((assento > 0) && (assento <= voos[i].getAssentos().length)){
          // este assento ainda está vazio?
          if(voos[i].getAssentos()[assento - 1].getPassageiro() == null){
            System.out.print("Nome do passageiro: ");
            String nome = input.nextLine();
            System.out.print("Idade do passageiro: ");
            int idade = Integer.parseInt(input.nextLine());
            System.out.print("Sexo do passageiro (M ou F): ");
            char sexo = input.nextLine().charAt(0);
            Passageiro p = new Passageiro(nome, idade, sexo);
            // coloca o passageiro neste assento
            voos[i].getAssentos()[assento - 1].setPassageiro(p);
            System.out.println("\nReserva efetuada com sucesso.\n");
            break;
          }
          else{
            System.out.println("\nEste assento não está disponível.\n");
            break;  
          }
        }
        else{
          System.out.println("\nO número do assento não é válido.\n");
          break;  
        }
      }  
    }
    
    // o voo não foi encontrado, né?
    if(!encontrado){
      System.out.println("\nO voo não foi encontrado.\n");  
    }
  }
  
  public static void listarReservas(){
    System.out.print("\nInforme o voo: ");
    int numero = Integer.parseInt(input.nextLine());
    boolean encontrado = false; // para informar se o voo foi encontrado
    
    for(int i = 0; i < voos.length; i++){
      if((voos[i] != null) && (voos[i].getNumero() == numero)){ // o voo foi encontrado?
        encontrado = true;
        // vamos mostrar as reservas para este voo
        System.out.println("\nRESERVAS PARA O VOO " + numero + ":\n");
        // percorre os assentos deste voo
        int quantReservas = 0;
        for(int j = 0; j < voos[i].getAssentos().length; j++){
          // há passageiro neste assento?
          if(voos[i].getAssentos()[j].getPassageiro() != null){
            quantReservas++;
            System.out.println("Assento: " + voos[i].getAssentos()[j].getNumero());
            System.out.println("Nome: " + voos[i].getAssentos()[j].getPassageiro().getNome());
            System.out.println("Idade: " + voos[i].getAssentos()[j].getPassageiro().getIdade());
            System.out.println("Sexo: " + voos[i].getAssentos()[j].getPassageiro().getSexo() + "\n");
          }
        }
        
        System.out.println(quantReservas + " reservas encontradas.\n");
      }  
    }
    
    // o voo não foi encontrado, né?
    if(!encontrado){
      System.out.println("\nO voo não foi encontrado.\n");  
    }
  }
}
