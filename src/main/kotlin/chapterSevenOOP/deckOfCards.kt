package chapterSevenOOP

internal enum class Suit {
    CLUB,
    DIAMOND,
    HEART,
    SPADE
}

internal open class Card(val faceValue: Int, val suit: Suit) {
    var isAvailable = true

    fun markUnavailable() {
        isAvailable = false
    }
}

internal class BlackjackCard(faceValue: Int, suit: Suit) : Card(faceValue, suit) {
    val value: Int
        get() = if (faceValue > 10) 10 else faceValue
}

internal class Deck<T : Card>(private val deckOfCards: ArrayList<T>) {
    fun shuffle() {
        deckOfCards.shuffle()
    }

    fun dealHand(number: Int): List<T> {
        val list = mutableListOf<T>()
        for (i in 0 until number) {
            if (deckOfCards.size <= 0) return listOf()
            list.add(deckOfCards.removeAt(0))
        }

        return list
    }

    fun dealCard(): T? {
        if (deckOfCards.size <= 0) return null
        return deckOfCards.removeAt(0)
    }
}

internal open class Hand<T : Card> {
    protected val cards = ArrayList<T>()

    open fun score(): Int {
        return cards.fold(0) { sum, element -> sum + element.faceValue }
    }

    fun addHand(card: T) {
        cards.add(card)
    }
}

internal class BlackJackHand : Hand<BlackjackCard>() {
    override fun score(): Int {
        return cards[0].value + cards[1].value
    }
}

fun main() {
    val deck = Deck(ArrayList<BlackjackCard>())

    val oneHand = BlackJackHand()
    deck.dealCard()?.let { oneHand.addHand(it) } // and so on
}