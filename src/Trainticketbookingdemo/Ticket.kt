import java.sql.DriverManager
//modelling class
data class Ticket(val Ticket_id:Int, val Ticket_number:Int,val passenger_id:Int,val Train_id:Int, val Ticket_price:Int)
fun main(args:Array<String>) {
    val jdbcUrl = "jdbc:mysql://localhost:3306/Trainticketdb"
    val connection = DriverManager.getConnection(jdbcUrl, "root", "Aryamadhu20#")
    println(connection.isValid(0))

    //insert query-create
   /*val res = connection.createStatement().executeUpdate("insert into Ticket(Ticket_id,Ticket_number,passenger_id,Train_id,Ticket_price) values(1005,78765,5,105,1600)")
        if (res > 0) {
            println("Successfully inserted a record into db!!!")
        } else {
            println("Insert not successful")
        }
       //update table
       val res_update=connection.createStatement().executeUpdate("update Ticket set Ticket_price=2600 where Ticket_id=1002")
       if(res_update > 0){
           println("Successfully updated a record into db!!!")
       }
       else{
           println("updation not successful")
       }*/
    //delete query

   val delete_res = connection.createStatement().executeUpdate("delete from Ticket where Ticket_id=1005")
    if (delete_res > 0) {
        println("Successfully deleted a record from db!!!")
    } else {
        println("Deletion is not successful")
    }
    //fetch the record from database
    val query = connection.prepareStatement("select *  from Ticket")
    val result = query.executeQuery()
    val Ticket = mutableListOf<Ticket>()
    while (result.next()) {
        val Ticket_id = result.getInt("Ticket_id")
        val Ticket_number = result.getInt("Ticket_number")
        val passenger_id = result.getInt("passenger_id")
        val Train_id = result.getInt("Train_id")
        val Ticket_price = result.getInt("Ticket_price")
        Ticket.add(Ticket(Ticket_id,Ticket_number,passenger_id,Train_id,Ticket_price))

    }
    println(Ticket)
}