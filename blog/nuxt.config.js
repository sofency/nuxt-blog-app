export default {
  target: "static",
  // Global page headers: https://go.nuxtjs.dev/config-head
  head: {
    title: "sofency'blog",
    htmlAttrs: {
      lang: 'en'
    },
    meta: [
      { charset: 'utf-8' },
      { name: 'viewport', content: 'width=device-width, initial-scale=1' },
      { hid: 'description', name: 'description', content: 'sofency的博客小屋' },
      { name: 'format-detection', content: 'telephone=no' }
    ],
    link: [
      { rel: 'icon', type: 'image/x-icon', href: '/favicon.ico' },
      { rel: 'stylesheet', href: '/css/common.css' },
    ]
  },

  // Global CSS: https://go.nuxtjs.dev/config-css
  css: [
    'ant-design-vue/dist/antd.css'
  ],

  // Plugins to run before rendering page: https://go.nuxtjs.dev/config-plugins
  plugins: [
    '@/plugins/antd-ui',
    {
      src: '~/plugins/service',
      ssr: true,// 开启服务端渲染
    },
  ],

  // Auto import components: https://go.nuxtjs.dev/config-components
  components: true,

  // Modules for dev and build (recommended): https://go.nuxtjs.dev/config-modules
  buildModules: [
  ],

  // Modules: https://go.nuxtjs.dev/config-modules
  modules: [
    '@nuxt/content',
    '@nuxtjs/axios',
    '@nuxtjs/markdownit'
  ],
  markdownit: {
    preset: 'default',
    linkify: true,
    breaks: true,
    injected: true,
    runtime: true,
    use: [
      'markdown-it-div',
      'markdown-it-attrs',
      'markdown-it-highlightjs',
      'markdown-it-mark',
      'markdown-it-deflist'
    ]
  },
  // Build Configuration: https://go.nuxtjs.dev/config-build
  build: {
  },

  axios: {
    proxy: true, // 开启允许跨域
  },
  proxy: {
    '/api': {
      target: 'http://localhost:8080', // 代理转发的地址
      changeOrigin: true,
      pathRewrite: {
        '^/api': '' // api替换为空
      }
    }
  }
}
