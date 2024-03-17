<template>
  <div class="bg-img">
    <h3>{{ message }}</h3>
  </div>
</template>
<script>
export default {
  props: {
    message: String,
  },
};
</script>
<style scoped lang="less">
.bg-img {
  display: flex;
  position: relative;
  color: #fff;
  font-size: 1.5rem;
  line-height: 2rem;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  text-shadow: 0 0.1875rem 0.3125rem #1c1f21;
  height: 25rem;
  -o-object-fit: cover;
  object-fit: cover;
  background-position-x: center;
  background-position-y: center;
  background-size: cover;
  background-image: url("https://www.baicho.cn/usr/themes/Cuteen/static/img/default-list-bg.jpg");
}
.bg-img::before {
  content: "";
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background: rgba(0, 0, 0, 0.2);
}
</style>