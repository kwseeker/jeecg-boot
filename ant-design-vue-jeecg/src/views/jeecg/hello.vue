<template>
  <div>
    {{ msg }}
  </div>
</template>

<script>
import {getAction} from '@/api/manage'
export default {
  data () {
    return {
      msg: ""
    }
  },
  methods: {
    hello () {
      const url = '/test/jeecgDemo/hello'
      getAction(url).then((res) => {
        if (res.success) {
          this.msg = res.result;
        }
      })
    }
  },
  created() {
    this.hello();
  }
}
</script>