const express = require("express");
const router = express.Router();
const { getToken } = require("../utils/auth");
const baseUrl = "https://61c71fed90318500175472ff.mockapi.io/api/";
const axios = require("axios");

router.get("/filmes", async function (req, res, next) {
  const token = req.header("Authorization");
  if (!token || token !== getToken()) {
    res.status(401).send({ message: "Token inválido" });
  } else {
    try {
      const { data } = await axios.get(baseUrl + "filme");
      res.status(200).send(data);
    } catch (error) {
      res.status(400).send(error);
    }
  }
});

router.get("/filmes/:id", async function (req, res, next) {
  const token = req.header("Authorization");
  if (!token || token !== getToken()) {
    res.status(401).send({ message: "Token inválido" });
  } else {
    const { id } = req.params;
    try {
      const { data } = await axios.get(baseUrl + `filme/${id}`);
      res.status(200).send(data);
    } catch (error) {
      res.status(400).send(error);
    }
  }
});

router.delete("/filmes/:id", async function (req, res, next) {
  const token = req.header("Authorization");
  if (!token || token !== getToken()) {
    res.status(401).send({ message: "Token inválido" });
  } else {
    const { id } = req.params;
    try {
      const { data } = await axios.delete(baseUrl + `filme/${id}`);
      res.status(200).send(data);
    } catch (error) {
      res.status(400).send(error);
    }
  }
});

module.exports = router;
