import java.sql.DriverManager
//modelling class
data class Train(val Train_id:Int, val Train_no:Int,val Train_name:String,val Source:String,val Destination:String,val Start_date_time:String,val Arrival_date_time:String)
fun main(args:Array<String>) {
    val jdbcUrl = "jdbc:mysql://localhost:3306/Trainticketdb"
    val connection = DriverManager.getConnection(jdbcUrl, "root", "Aryamadhu20#")
    println(connection.isValid(0))

    //insert query-create
    val res = connection.createStatement().executeUpdate("insert into Train(Train_id,Train_no,Train_name,Source,Destination,Start_date_time,Arrival_date_time) values(105,99762,'Chennnai Express','Delhi','Chennai','09-08-2022 05:00 AM','12-08-2022 06:00PM')")
     if (res > 0) {
         println("Successfully inserted a record into db!!!")
     } else {
         println("Insert not successful")
     }
    //update table
    /*val res_update=connection.createStatement().executeUpdate("update Train set Train_name='Venad Express' where Train_id=105")
    if(res_update > 0){
        println("Successfully updated a record into db!!!")
    }
    else{
        println("updation not successful")
    }
    //delete query

    val delete_res=connection.createStatement().executeUpdate("delete from Train where Train_id=105")
    if(delete_res > 0){
        println("Successfully deleted a record from db!!!")
    }
    else{
        println("Deletion is not successful")
    }*/
    //fetch the record from database
    val query = connection.prepareStatement("select *  from Train")
    val result = query.executeQuery()
    val Train = mutableListOf<Train>()
    while (result.next()) {
        val Train_id = result.getInt("Train_id")
        val Train_no = result.getInt("Train_no")
        val Train_name = result.getString("Train_name")
        val Source = result.getString("Source")
        val Destination = result.getString("Destination")
        val Start_date_time = result.getString("Start_date_time")
        val Arrival_date_time = result.getString("Arrival_date_time")
        Train.add(Train(Train_id,Train_no,Train_name,Source,Destination,Start_date_time,Arrival_date_time))

    }
    println(Train)
}