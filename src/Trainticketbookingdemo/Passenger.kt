import java.sql.DriverManager
//modelling class
data class Passenger(val passenger_id:Int, val passenger_name:String,val passenger_age:Int,val passenger_gender:String,val passenger_phone:String)
fun main(args:Array<String>) {
    val jdbcUrl = "jdbc:mysql://localhost:3306/Trainticketdb"
    val connection = DriverManager.getConnection(jdbcUrl, "root", "Aryamadhu20#")
    println(connection.isValid(0))

    //insert query-create
   val res = connection.createStatement().executeUpdate("insert into Passenger(passenger_id,passenger_name,passenger_age,passenger_gender,passenger_phone) values(5,'Mthew',27,'Male','9778655678')")
    if (res > 0) {
        println("Successfully inserted a record into db!!!")
    } else {
        println("Insert not successful")
    }
    //update table
   /* val res_update=connection.createStatement().executeUpdate("update Passenger set passenger_name='Aleena',passenger_age=24,passenger_gender='Female' where passenger_id=4")
    if(res_update > 0){
        println("Successfully updated a record into db!!!")
    }
    else{
        println("updation not successful")
    }
    //delete query

    val delete_res=connection.createStatement().executeUpdate("delete from Passenger where passenger_id=5")
    if(delete_res > 0){
        println("Successfully deleted a record from db!!!")
    }
    else{
        println("Deletion is not successful")
      }*/
    //fetch the record from database
    val query = connection.prepareStatement("select *  from Passenger")
    val result = query.executeQuery()
    val Passenger = mutableListOf<Passenger>()
    while (result.next()) {
        val passenger_id = result.getInt("passenger_id")
        val passenger_name = result.getString("passenger_name")
        val passenger_age = result.getInt("passenger_age")
        val passenger_gender = result.getString("passenger_gender")
        val passenger_phone = result.getString("passenger_phone")
        Passenger.add(Passenger(passenger_id,passenger_name,passenger_age,passenger_gender,passenger_phone))

    }
    println(Passenger)
}