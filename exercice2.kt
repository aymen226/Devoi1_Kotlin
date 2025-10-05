package Revision





abstract class Vehicule(var immatriculation: String,
                        var marque: String, var modele: String,
                        var kilometrage: Int, var disponible: Boolean=true){
    open fun afficherDetails(){
        println("Immatriculation : $immatriculation \n " +
                "Marque : $marque, Modele : $modele \n " +
                " Kilometrage : $kilometrage, Disponible? : $disponible")
    }
    fun estDisponible(): Boolean{
        return disponible
    }
    fun marquerIndisponible(){
        disponible = false
    }
    fun marquerDisponible(){
        disponible = true
    }
    fun mettreAJourKilometrage(km: Int){
        kilometrage = km
    }
}

class Voiture(immatriculation: String, marque: String, modele: String,
              kilometrage: Int, disponible: Boolean, var nombrePortes: Int,
              var typeCarburant: String):
    Vehicule(immatriculation, marque, modele, kilometrage, disponible){
    override fun afficherDetails() {
        super.afficherDetails()
        println("Nombre des Portes : $nombrePortes, Type de Carburant : $typeCarburant")
    }
}


class Moto(immatriculation: String, marque: String,
           modele: String, kilometrage: Int, disponible: Boolean,
           var cylindree: Int):
    Vehicule(immatriculation, marque, modele, kilometrage, disponible) {
    override fun afficherDetails() {
        super.afficherDetails()
        println("Cylindree : $cylindree")
    }
}

class Conducteur(var nom: String, var prenom: String,
                 var numeroPermis: String){
    fun afficherDetails(){
        println("votre nom : $nom , votre prenom : \n " +
                "$prenom, Numero de Permis : $numeroPermis")
    }
}


class Reservation(var vehicule: Vehicule, var conducteur: Conducteur
, var dateDebut: String, var dateFin: String, var kilometrageDebut: Int,
                  var kilometrageFin: Int? = null){
    fun cloturerReservation(kilometrageRetour: Int){
        kilometrageFin = kilometrageRetour
        vehicule.marquerDisponible()
        vehicule.mettreAJourKilometrage(kilometrageRetour)
    }

    fun afficherDetails() {
        println(" reservation")
        println("Vehicule: ${vehicule.immatriculation} (${vehicule.marque} ${vehicule.modele})")
        println("Conducteur: ${conducteur.prenom} ${conducteur.nom} | Permis: ${conducteur.numeroPermis}")
        println("Début: $dateDebut  | Fin prévue: $dateFin")
        println("Km début: $kilometrageDebut | Km fin: ${kilometrageFin ?: "Non renseigné"}")

    }
}


class ParcAutomobile(var vehicules : MutableList<Vehicule> , var reservations : MutableList<Reservation>){
    fun ajouterVehicule(vehicule: Vehicule){
        vehicules.add(vehicule)
    }
    fun supprimerVehicule(immatriculation: String){
        vehicules.forEach { ele -> if (ele.immatriculation == immatriculation){
            vehicules.remove(ele)
        }
        }
    }
    fun reserverVehicule(immatriculation: String, conducteur: Conducteur, dateDebut: String, dateFin: String) {
        vehicules.forEach { ele -> if (ele.immatriculation == immatriculation){
            ele.marquerIndisponible()
        }
        }
    }

    fun afficherVehiculesDisponibles(){
        vehicules.forEach { ele -> if (ele.disponible){
            ele.afficherDetails()
        }
        }
    }
    fun afficherReservations(){
        vehicules.forEach { ele -> if (!ele.disponible){
            ele.afficherDetails()
        }
        }
    }
}



//Partie 4 : Gestion des Exceptions

class VehiculeIndisponibleException(message: String): Exception(message)
class VehiculeNonTrouveException(message: String): Exception(message)

fun main(){
    var voiture1 = Voiture("A-2334", "BMW", "2020",
        500, true, 4, "essence")

    var voiture2 = Voiture("V9988", "BMW", "2020",
        500, true, 4, "essence")

    var moto = Moto("B4566", "CIH", "2019",
        100, true, 1210)

    var vehicules = mutableListOf<Vehicule>()
    var reservations = mutableListOf<Reservation>()

    var parc = ParcAutomobile(vehicules , reservations)

    parc.ajouterVehicule(voiture1)
    parc.ajouterVehicule(voiture2)
    parc.ajouterVehicule(moto)
    println("✅ Véhicules ajoutés au parc automobile.\n")

    var c1 = Conducteur("faysal", "elallaoui", "123")
    var c2 = Conducteur("aymen", "zagnouni", "456")
    var c3 = Conducteur("othmane", "edhane", "294")
    parc.afficherVehiculesDisponibles()
    parc.afficherReservations()


    try {
        val r1 = parc.reserverVehicule("V9988", c2,
            "10-10-2025", "20-10-2025")
    } catch (e: Exception) {
        println("Erreur réservation: ${e.message}")
    }


    try {
        val r2 = parc.reserverVehicule("V9988", c2,
            "10-10-2025", "20-10-2025")
    } catch (e: VehiculeIndisponibleException) {
        println("Gestion d'erreur: ${e.message}")
    } catch (e: Exception) {
        println("Erreur réservation: ${e.message}")
    }

    try {
        parc.reserverVehicule("B4566", c3,
            "10-10-2025", "20-10-2025")
    } catch (e: VehiculeNonTrouveException) {
        println("Gestion d'erreur: ${e.message}")
    } catch (e: Exception) {
        println("Erreur réservation: ${e.message}")
    }

    val r3 = try {
        parc.reserverVehicule("A-2334", c1,
            "10-10-2025", "20-10-2025")
    } catch (e: Exception) {
        null
    }


    parc.afficherVehiculesDisponibles()
    parc.afficherReservations()

    // Prenons la première réservation (si elle existe)
    val premiereReservation = parc.reservations.firstOrNull()
    if (premiereReservation != null) {
        println("\nClôture de la première réservation...")
        premiereReservation.cloturerReservation(
            premiereReservation.kilometrageDebut + 450)
    }

    parc.afficherVehiculesDisponibles()
    parc.afficherReservations()
    parc.supprimerVehicule("GG-000-HH")

    println("\nÉtat final du parc :")
    parc.vehicules.forEach { it.afficherDetails() }
}
