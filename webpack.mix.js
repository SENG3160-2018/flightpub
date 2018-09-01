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

mix.js('src/main/webapp/src/js/app.js', 'src/main/webapp/dist/js/app.js');

mix.sass('src/main/webapp/src/sass/bootstrap.scss', 'src/main/webapp/dist/css/bootstrap.css');
mix.less('src/main/webapp/src/less/styles.less', 'src/main/webapp/dist/css/styles.css');
