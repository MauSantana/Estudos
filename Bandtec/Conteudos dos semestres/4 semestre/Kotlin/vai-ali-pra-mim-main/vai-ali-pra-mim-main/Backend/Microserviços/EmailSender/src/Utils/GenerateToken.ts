export default function GenerateToken() {
    let token = "";
    for (let i = 0; i < 4; i++) {
        token += `${(Math.random() * 9).toFixed(0)}`
    }
    
    return token
}
