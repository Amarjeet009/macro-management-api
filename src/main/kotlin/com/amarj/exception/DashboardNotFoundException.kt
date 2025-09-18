package com.amarj.exception

class DashboardNotFoundException(id: Long) : RuntimeException("Dashboard with ID $id not found")