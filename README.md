# NASA API - Spring Boot

A Spring Boot REST API that integrates with NASA's APOD
(Astronomy Picture of the Day) API.

## Features

- Spring Boot REST API
- External API integration using RestClient
- DTO-based JSON mapping
- Service and Client layers
- Exception handling
- Global exception handling with @RestControllerAdvice
- Request validation
- HTTP status codes
- Configuration using environment variables

## Architecture

Controller
↓
Service
↓
Client
↓
NASA API

## Endpoint

GET /apod?date=yyyy-MM-dd

Example:

GET /apod?date=2026-10-01

## Error Handling

- 400 Bad Request - Invalid date
- 502 Bad Gateway - NASA API failure

## Configuration

Set the NASA API key as an environment variable:

NASA_API_KEY=your_api_key

The application reads it through:

nasa.api.key=${NASA_API_KEY}