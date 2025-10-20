package com.example.myapplication.data

import com.fasterxml.jackson.annotation.JsonProperty

data class Country (
    @JsonProperty("name") val name: String,
    @JsonProperty("flag") val flag: String,
    @JsonProperty("capital") val capital: String,
    @JsonProperty("population") val population: Float,
    @JsonProperty("density") val density: Int,
    @JsonProperty("area") val area: Int,
    @JsonProperty("world_share") val worldShare: String
    )