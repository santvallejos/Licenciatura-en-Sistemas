<?php

use Illuminate\Support\Facades\Route;
use App\Http\Controllers\ContactoController;

Route::get('/', function () {
    return view('welcome');
});

Route::get('/aboutme', function () {
    return view('about-me');
});

Route::get('/contacto', function () {
    return view('contacto');
});

Route::post('/contacto', [ContactoController::class, 'procesar']);
