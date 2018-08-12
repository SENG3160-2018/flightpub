let mix = require('laravel-mix');

/*
 |--------------------------------------------------------------------------
 | Mix Asset Management
 |--------------------------------------------------------------------------
 |
 | Mix provides a clean, fluent API for defining some Webpack build steps
 | for your Laravel application. By default, we are compiling the Sass
 | file for your application, as well as bundling up your JS files.
 |
 */

mix.js('web/src/js/app.js', 'web/dist/js/app.js');

mix.sass('web/src/sass/bootstrap.scss', 'web/dist/css/bootstrap.css');
mix.less('web/src/less/styles.less', 'web/dist/css/styles.css');
