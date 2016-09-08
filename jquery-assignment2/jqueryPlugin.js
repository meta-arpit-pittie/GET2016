/*Assignment 5
To implement any jquery plugin*/
$(document).ready(init);

function init() {
    $('#blurEffect').on('click', function( e ) {
            Custombox.open({
                target: 'popup.html',
                effect: 'blur',
                escKey: 'true'
            });
            e.preventDefault();
        });
    
    $('#signEffect').on('click', function( e ) {
            Custombox.open({
                target: 'popup.html',
                effect: 'sign',
                escKey: 'true'
            });
            e.preventDefault();
        });
    
    $('#doorEffect').on('click', function( e ) {
            Custombox.open({
                target: 'popup.html',
                effect: 'door',
                escKey: 'true',
                speed: 3000
            });
            e.preventDefault();
        });
    
    $('#makewayEffect').on('click', function( e ) {
            Custombox.open({
                target: 'popup.html',
                effect: 'makeway',
                escKey: 'true',
                overlayColor: '#33fad2'
            });
            e.preventDefault();
        });
    
    $('#contentscaleEffect').on('click', function( e ) {
            Custombox.open({
                target: 'popup.html',
                effect: 'contentscale',
                escKey: 'true'
            });
            e.preventDefault();
        });
    
    $('#slipEffect').on('click', function( e ) {
            Custombox.open({
                target: 'popup.html',
                effect: 'slip',
                escKey: 'true',
                speed: 3000
            });
            e.preventDefault();
        });
    
    $('#slidetogetherEffect').on('click', function( e ) {
            Custombox.open({
                target: 'popup.html',
                effect: 'slidetogether',
                escKey: 'true',
                overlayOpacity: 0.75
            });
            e.preventDefault();
        });
    
    $('#letmeinEffect').on('click', function( e ) {
            Custombox.open({
                target: 'popup.html',
                effect: 'letmein',
                escKey: 'true',
                position: ['center','bottom']
            });
            e.preventDefault();
        });
    
    $('#sidefallEffect').on('click', function( e ) {
            Custombox.open({
                target: 'popup.html',
                effect: 'sidefall',
                escKey: 'true',
                position:['center','center']
            });
            e.preventDefault();
        });
    
    $('#newspaperEffect').on('click', function( e ) {
            Custombox.open({
                target: 'popup.html',
                effect: 'newspaper',
                escKey: 'true',
                overlayEffect: 'push'
            });
            e.preventDefault();
        });
}