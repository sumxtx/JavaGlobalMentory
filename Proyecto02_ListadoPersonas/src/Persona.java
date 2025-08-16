public class Persona 
{

  private int id;
  private String name;
  private String tel;
  private String email;
  private static int numPersona = 0;

  // Constructor vacio
  public Persona()
  {
    this.id = ++Persona.numPersona;
  }

  // Constructor con argumentos
  public Persona(String nombre, String tel, String email)
  {
    this();
    this.name = nombre;
    this.tel = tel;
    this.email = email;
  }

  public int getId()
  {
    return id;
  }

  public void setId(int id)
  {
    this.id = id;
  }

  public String getNombre()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public String getTel()
  {
    return tel;
  }

  public void setTel()
  {
    this.tel = tel;
  }

  public String getEmail()
  {
    return email;
  }

  public void setEmail(String email)
  {
    this.email = email;
  }

  @Override
  public String toString()
  {
    return "Persona {" + "id = " + id + " nombre = " + name + " telefono = " + tel + " email = " + email + "}";
  }
}
