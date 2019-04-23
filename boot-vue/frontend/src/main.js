// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'

import HeaderArea from './components/Header.vue';
import FooterArea from './components/Footer.vue';
import CenterArea from './components/Center.vue';

Vue.config.productionTip = false

Vue.component('header-area', HeaderArea);
Vue.component('footer-area', FooterArea);
Vue.component('center-area', CenterArea);

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
