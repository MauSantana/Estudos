
import moment from 'moment'
import connection from '../database/connection'

interface emailProps {
    email: string,
    token: string,
    updatedAt: string,
    createadAt: string
}


export default class CodeVerificationService {

    async execute(email: string, code: string): Promise<Number> {

        let retrievedDocs = await connection.select("*").where({ email }).from("token")
        if (retrievedDocs.length == 0)
            return 404

        let doc: emailProps = retrievedDocs[0];
        let expiredDate = moment.utc(doc.updatedAt).add(10, 'minutes')
        let currentDate = moment.utc()

        if (doc.token == code && doc.email == email) {
            if (currentDate < expiredDate)
                return 200;
            else
                return 401
        } else {
            return 404
        }
    }
}