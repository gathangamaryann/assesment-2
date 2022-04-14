fun main(){
    var myAccount=CurrentAccount("05574634","airbank",10000.0)
    myAccount.deposit(5000.0)
    myAccount.withdraw(500.5)
    myAccount.details()

    var mySavingsAccount=SavingsAccount("000475663","marybank",50000.5,2)
    mySavingsAccount.deposit(3000.5)
    mySavingsAccount.withdraw(1000.5)
    println( mySavingsAccount.withdrawals)
    mySavingsAccount.details()

    var a=Product("handkerchif",12.0,10.0,"hygiene")
    var b=Product("tissue",10.0,30.5,"hygiene")
    var c=Product("pen",1.5,10.5,"other")
    var d=Product("cabbage",3.5,70.0,"groceries")
    assignProducts(a)
    assignProducts(b)
    assignProducts(c)
    assignProducts(d)

    evenIndicesChar("banana")
    evenIndicesChar("maryannn")


}
open class CurrentAccount(var accountNumber:String,var accountName:String,var balance:Double){
    fun deposit(amount:Double){
        balance+=amount
        println(balance)
    }
    open fun withdraw(amount: Double){
        balance-=amount
        println(balance)
    }
    fun details(){
        println("Account number $accountNumber with balance $balance is operated by $accountName")
    }

}
class SavingsAccount(accountNumber: String,accountName: String,balance: Double, var withdrawals:Int):CurrentAccount(accountNumber,accountName,balance){
    override fun withdraw(amount: Double) {
        if (withdrawals<4){
            balance-=amount
        }
        println(balance)
        withdrawals++
    }
}
data class Product(var name:String, var weight:Double,var price:Double,var category:String)
fun assignProducts(product:Product){

    var groceriesLists= mutableListOf<Product>()
    var hygieneLists= mutableListOf<Product>()
    var otherLists= mutableListOf<Product>()
    when(product.category){
        "groceries"-> groceriesLists.add(product)
        "hygiene"->hygieneLists.add(product)
        "other"->otherLists.add(product)
    }
    println( listOf(product))

}
fun evenIndicesChar(word:String):String{
    var newWord=""
    word.forEachIndexed { index, c ->
        if (index%2==0){
            newWord+=c
        }
    }
    println(newWord)
    return newWord

}
