package main.QMP6;

public class Observer {
  //implementar
  public void recibirPost(post: Post) {
    validacionEnvio.validarPost(post, this)
    postObservers.forEach { it.postEnviado(post, this) }
  }


}
