import { defineConfig } from 'umi';

export default defineConfig({
  mock: false,
  proxy: {
    '/api': {
      'target': 'http://127.0.0.1:727/mekatok/',
      'changeOrigin': true,
      'pathRewrite': {
        '^/api' : '/api'
      }
    }
  }
})
