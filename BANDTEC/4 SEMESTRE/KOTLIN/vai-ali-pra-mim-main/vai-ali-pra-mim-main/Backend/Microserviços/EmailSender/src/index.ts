import cors from 'cors'
import express from 'express'

import EmailServiceClass from './services/EmailService'
import CodeVerificationClass from './services/CodeVerificationService'
import CreateTokenClass from './services/CreateTokenService'
import GenerateToken from './Utils/GenerateToken'
import connection from './database/connection'

let EmailService = new EmailServiceClass()
let CodeVerificationService = new CodeVerificationClass()
let CreateTokenService = new CreateTokenClass()
const app = express();
const PORT = 3000;
const HOST = '0.0.0.0';

app.use(cors())
app.use(express.json())

app.get("/token", async (req, res) => {
    let tokens: any = await connection("token").select("*");
    return res.status(200).json({ tokens })
})

app.post("/token365", async (req, res) => {
    let { email } = req.body;
    let generatedToken = GenerateToken();

    if (email == null || email == "" || req.body.constructor === Object && Object.keys(req.body).length === 0)
        return res.status(400).json()

    let statusCode = CreateTokenService.execute(email, generatedToken)
    EmailService.execute(email, generatedToken)
    statusCode.then(item => res.status(item as number).json())

})

app.post("/token/codeVerification", async (req, res) => {
    let { email, code } = req.body;
    email = String(email).toLowerCase();

    if (email == null || email == "" || code == null || code == "" || req.body.constructor === Object && Object.keys(req.body).length < 2)
        return res.status(400).json()

    let statusCode: Promise<Number> = CodeVerificationService.execute(email, code);
    statusCode.then(item => res.status(item as number).json())

})

app.listen(Number(process.env.PORT) || PORT , HOST, () => {
    console.log(`Servidor rodando na porta: ${PORT}`);
});