import connection from '../database/connection'

export default class CreateTokenService {

    async execute(email: string, generatedToken: string):Promise<Number> {
        let dateTimeNow = new Date()
        let emailFound = await connection.select("*").where({ email }).from("token")

        if (emailFound.length > 0) {
            await connection('token').where({
                email
            }).update({ token: generatedToken, updatedAt: dateTimeNow },)

            return 201;
        } else {
            await connection("token").insert({ token: generatedToken, email, createdAt: dateTimeNow, updatedAt: dateTimeNow })
           
            return 200;
        }
    }
}