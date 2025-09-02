package com.example.printers.data

data class DataModel(
    val name: String,
    val type: String,
    val ip: Int,
    val isMain: Boolean,
    val isOffline: Boolean,
    val isError: Boolean
)
