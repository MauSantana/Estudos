import knex from "knex"

let connection = knex({
  client: "mssql",
  connection: {
    host: "vapm.database.windows.net",
    user: "localadmin",
    password: "#Gfgrupo2",
    database: "VAPM-Database",
  }
})


export default connection;