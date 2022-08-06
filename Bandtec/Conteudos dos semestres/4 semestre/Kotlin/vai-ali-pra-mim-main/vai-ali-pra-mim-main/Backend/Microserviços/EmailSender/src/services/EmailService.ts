import nodemailer from 'nodemailer'

export default class EmailSender {
    transport: any;

    constructor() {
        this.transport = nodemailer.createTransport({
            host: "SMTP.office365.com",
            port: 587,
            auth: {
                user: "192-3a-grupo2@bandtec.com.br",
                pass: "#Gfgrupo2"
            }
        });
    }

    async execute(receiverEmail: string, codeVerification: string): Promise<void> {
        await this.transport.sendMail({
            from: '192-3a-grupo2@bandtec.com.br',
            to : receiverEmail,
            subject: 'Código de verificação VAI-ALI-PRA-MIM',
            html: `<h1>Código verificação - Vai Ali Pra Mim </h1> <br/>
            Seu código de verificação é: <h2>${codeVerification}</h2>`
        })
    }
}