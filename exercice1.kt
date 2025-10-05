


open class Personne (var nom: String,
                     var prenom: String,
                     var email:String ){
    open fun afficherInfos(){
        println("votre nom complet est :$nom  $prenom \n votre email:$email")
    }
}

//////////////////////////////

class Utilisateur(var idUtilisateur:Int ,
                  val emprunts: MutableList<Emprunt> = mutableListOf() ,
                  nom: String,  prenom: String, email:String):
    Personne(nom,prenom,email){

    fun emprunterLivre(livre: Livre, dateEmprunt: String){
        if (livre.disponiblePourEmprunt()){
            livre.mettreAJourStock(livre.nombreExemplaires-1)
            val emprunt= Emprunt(this,livre,dateEmprunt)
            emprunts.add(emprunt)
        }
    }
    fun afficherEmprunts() {
        if (emprunts.isEmpty()) {
            println("$nom $prenom n'a pas d'emprunts.")
        } else {
            println("emprunts de $nom $prenom :")
            emprunts.forEach { it.afficherDetails() }
        }
    }
}
//////////////////////////////

class Livre (var titre : String, var auteur : String ,
             var isbn : String,
             var nombreExemplaires : Int){
    fun disponiblePourEmprunt(): Boolean{
        return nombreExemplaires >= 1

    }
    fun mettreAJourStock( nouveauStock: Int){
        nombreExemplaires = nouveauStock
    }

    fun afficherDetails(){
        println("le titre est :$titre ,\n l'auteur:$auteur," +
                " \n isbn:$isbn \n" +
                " nombre exemplaires : $nombreExemplaires")
    }
}
/////////////////////////////////////

class Emprunt(var utilisateur : Utilisateur,
              var livre : Livre,
              var dateEmprunt : String,
              var dateRetour : String?= null){
    fun afficherDetails(){
        println("utilisateur : ${utilisateur.nom}\n " +
                "livre: ${livre.titre} \n " +
                "est en stock : ${livre.nombreExemplaires}) \n" +
                " date emprunt : $dateEmprunt \n" +
                " date retour : $dateRetour")
    }
    fun retournerLivre(date: String ){
        dateRetour= date
        livre.mettreAJourStock(livre.nombreExemplaires+1)
    }
}

/////////////////////////////


abstract class GestionBibliotheque(){
    val utilisateurs : MutableList<Utilisateur> = mutableListOf()
    val livres : MutableList<Livre> = mutableListOf()
    abstract fun ajouterUtilisateur(utilisateur: Utilisateur)
    abstract fun ajouterLivre(livre: Livre)
    abstract fun afficherTousLesLivres()
}


///////////////////////////////


class Bibliotheque():GestionBibliotheque(){
    override fun ajouterUtilisateur(utilisateur: Utilisateur) {
        utilisateurs.add(utilisateur)
    }
    override fun afficherTousLesLivres() {
        livres.forEach { ele -> println(ele) }
    }

    override fun ajouterLivre(livre: Livre) {
        livres.add(livre)
    }
}


fun main(){
    var livre1= Livre("titre1",
        "jhon","124668569",142)

    var livre2= Livre("titre2",
        "paul","14659876",340)

    var livre3= Livre("titre3","fati","25846",420)
    var bibliotheque= Bibliotheque()

    bibliotheque.ajouterLivre(livre1)
    bibliotheque.ajouterLivre(livre2)
    bibliotheque.ajouterLivre(livre3)

    var listes= mutableListOf<Emprunt>()

    var user01= Utilisateur(1,listes,
        "naima","Ziane","zianenaima@gmail.com")

    var user02= Utilisateur(2,listes,
        "fatima","aicha","aichafatima@gmail.com")

    var user03= Utilisateur(3,listes,
        "kawtar","elggadi","elggadikawtar@gmail.com")


    bibliotheque.ajouterUtilisateur(user01)
    bibliotheque.ajouterUtilisateur(user02)
    bibliotheque.ajouterUtilisateur(user03)

    var emprunt1 = Emprunt(user01,livre1,"1/10/25")
    var emprunt2 = Emprunt(user02,livre2,"1/10/25")
    var emprunt3 = Emprunt(user03,livre3,"1/10/25")

    listes.add(emprunt1)
    listes.add(emprunt2)
    listes.add(emprunt3)

    println("**************** etat initial des livres ******************")

    livre1.afficherDetails()
    livre2.afficherDetails()
    livre3.afficherDetails()

    println("*************** Utilisateurs  *****************")
    user01.afficherInfos()
    user02.afficherInfos()
    user03.afficherInfos()

    println("************* Emprunts crees manuellement  *************")
    emprunt1.afficherDetails()
    emprunt2.afficherDetails()
    emprunt3.afficherDetails()
    println("************* Emprunts via fonction emprunterLivre() *************")
    user01.emprunterLivre(livre1,"4/10/25")
    user02.emprunterLivre(livre2,"4/10/25")
    user03.emprunterLivre(livre3,"4/10/25")
    emprunt1.retournerLivre("20/10/25")
    user01.emprunterLivre(livre1,"20/10/25")
    livre1.afficherDetails()
    emprunt1.afficherDetails()





}