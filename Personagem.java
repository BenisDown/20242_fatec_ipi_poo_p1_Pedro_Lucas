public class Personagem{
  String nome;
  private int energia;
  private int fome;
  private int sono;
  private boolean morto;


  Personagem(){
    System.out.println("Construindo novo personagem");
    energia = 10;
    fome = 0;
    sono = 0;
  }


  Personagem(int energia, int fome, int sono) {
    System.out.println("Construindo novo personagem");
    this.energia = energia < 0 || energia > 10 ? 10 : energia;
    this.fome = fome >= 0 && fome <= 10 ? fome : 0;
    this.sono = sono >= 0 && sono <= 10 ? sono : 0;
  }

  void cacar(){
    if(energia >= 2){
      System.out.printf("%s caçando\n", nome);
      energia -= 2; // energia = energia - 2
    }else{
      System.out.printf(
        "%s sem energia para caçar\n",
        nome
      );
    }
    // fome +=1 fome++ ++fome
    if (fome < 10) fome = fome + 1; 
    // sono = sono + 1 > 10 ? sono : sono + 1;
    sono = sono == 10 ? sono : sono + 1;
  }

  //método comer
  void comer(){
    if(fome >= 1){
      System.out.println(nome + " comendo");
      energia = Math.min(energia + 1, 10);
      fome--;
    }
    else{
      System.out.println(nome + " sem fome");
    }
  }
  //método dormir
  void dormir(){
    if(sono >= 1){
      System.out.print(nome + " dormindo\n");
      energia = energia == 10 ? energia : energia + 1;
      sono -= 1;
    }else{
      System.out.println(nome + " sem sono");
    }
  }

  boolean morrer() {
    if (energia <= 0) {
      System.out.println(nome + " Ficou sem energia");
      System.out.println("Game Over para o jogador: " + nome);
      morto = true;
      return true;
    }
    return morto;
  }
  public boolean isMorto() {
    return morto;
  }
  void atacar(Personagem inimigo){
    System.out.println(nome + " Atacou!!! " + inimigo.nome + "\n");
    inimigo.energia--;
    if(inimigo.energia == 0) inimigo.morrer(); 
  }  

  public String toString(){
    if (nome == null) {
      throw new NullPointerException("nome == null");
    }
    //nome: e:5, f:4, s:8
    return String.format(
      "%s: e:%d, f:%d, s:%d",
      nome, energia, fome, sono
    );
  }
}
