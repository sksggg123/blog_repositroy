<template>
  <div id="app">
    <!--<img src="./assets/logo.png">-->

    <div class="header">
      <header-area></header-area>
    </div>

    <div class="container">
      <center-area></center-area>
    </div>

    <div class="footer">
      <footer-area></footer-area>
    </div>

    <!--<router-view/>-->
  </div>
</template>

<script>
  // import HeaderArea from './components/Header.vue';
  // import FooterArea from './components/Footer.vue';

  export default {
    name: 'App',
    // components: {
    //   'header-area' : HeaderArea,
    //   'footer-area' : FooterArea,
    // }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}

  .header {
    margin:0px;
    padding:10px;
    background: #6bb8cc;
  }

  .container {
    margin-left:1px;
    font-size:1.1em;
    display:inline;
    font-weight:bold;
  }

  .footer {
    position:absolute;
    bottom:0;
    width:100%;
    height:100px;
    background: #6bb8cc;
  }
</style>
