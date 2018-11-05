class RpgPresenter {

    companion object {
        val YES_ANSWER = "Y"
        val NO_ANSWER = "N"
    }

    private val view: RpgConsole = RpgConsole(this)

    fun start() {
        view.showWelcomeMessage()
        view.askNickname()

        var playerName = view.getNicknameAnswer()
        //playerName = playerName ?: "Defaut"
        //Elvis operator ?:    =   if(playerName = null) return "Defaut"
        view.showNickname(playerName)
        askToStartTheDungeon()
        val player = Player(playerName)
        /*
        player.toString()
        player.copy()
        player.equals()
        player.hashCode()
        */
    }

    fun askToStartTheDungeon() {
        println("Veux tu entrer dans le donjon ?")
        println(" ${YES_ANSWER} -> pour commencer")
        println(" ${NO_ANSWER} -> pour quitter")
        print("Answer : ")
        val answer = readLine()!!

        when (answer.toUpperCase()) {
            YES_ANSWER -> println("C'est parti..")
            NO_ANSWER -> println("Bye bye...")
            else -> askToStartTheDungeon()
        }
    }
}
/*
Consigne pour le 12 novembre avant 23h59

Passage en mvp de la fonction askToStartTheDungeon
Un pnj doit vous demander une arme (enum Weapon)
Suivant l'arme que vous choississez
- il faut ajouter l'arme à l'objet  Player
- Afficher les caractèristiques de l'arme
-  Gérer le cas d'erreur du choix de l'arme

*/


/*if (answer.toUpperCase() == Main.YES_ANSWER) {
    //"y"
    println("C'est parti..")
} else if(answer.toUpperCase() == Main.NO_ANSWER){
    //"n"
    println("Bye bye...")
} else {
    askToStartTheDungeon()
}*/

/* exemple de fonction
fun sayHello(): String {
    return "hello"
}

fun sayHello() = "hello"
*/
