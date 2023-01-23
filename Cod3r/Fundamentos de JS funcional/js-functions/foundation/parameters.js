function logParams(a, b, c) {
    console.log(a, b, c)
}

logParams(1, 2, 3, 4, 5)
logParams(1, 2, 3)
logParams(1, 2)
logParams()

function defaultParams(a = 1, b = 2, c = 3) {
    console.log(a, b, c)
}

defaultParams(7, 8, 9)
defaultParams(7, 8)
defaultParams(7)
defaultParams()

// spread/rest
function logNums(...nums) {
    // console.log(Array.isArray(nums))
    console.log(nums)
}

logNums (1, 2, 3)

function sumAll(...nums) {
    
}