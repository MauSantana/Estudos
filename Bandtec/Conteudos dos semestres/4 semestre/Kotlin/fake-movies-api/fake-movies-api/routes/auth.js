const express = require("express");
const router = express.Router();
const { getToken } = require("../utils/auth");

router.post("/login", function (req, res, next) {
  const { email, password } = req.body;
  const regex = new RegExp("@sptech.school$", "gim");
  if (email.trim().match(regex) && password.trim() == "123456") {
    res.status(200).send({ token: getToken() });
  } else {
    res.sendStatus(403);
  }
});

module.exports = router;
