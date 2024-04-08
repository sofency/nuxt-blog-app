<template>
  <div class="container">
    <ul class="category-list">
      <li class="category-list-item" v-for="archive in archives" :key="archive">
        <NuxtLink
          :to="`/archive/${archive.archive.id}?name=${archive.archive.name}`"
          class="archive-item"
        >
          {{ archive.archive.name }} ({{ archive.count }})
        </NuxtLink>
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  props: {
    archives: Array,
  },
};
</script>
<style scoped lang="less">
.container {
  width: 80%;
  margin-left: auto;
  margin-right: auto;
  margin-top: 20px;
  border: 1px solid red;
  padding: 20px;
  border-radius: 10px;
  .category-list li {
    position: relative;
    margin: 6px 0;
    padding: 0.12em 0.4em 0.12em 1.4em;
    list-style-type: none; /* 去除列表项前的标记 */

    .category-list-item:hover {
      color: #225a50;
    }
  }
  .category-list ul {
    list-style: none;
  }
  li:before {
    position: absolute;
    top: 0.67em;
    left: 0;
    width: 0.88em;
    height: 0.88em;
    border: 0.25em solid #225a50;
    border-radius: 0.88em;
    background: transparent;
    content: "";
    cursor: pointer;
    transition: all 0.3s ease-out;
  }

  .archive-item {
    color: var(--font-color);
    font-size: var(--global-font-size);
    font-family: system-ui, -apple-system, BlinkMacSystemFont, segoe ui, Roboto,
      Helvetica, Arial, sans-serif, apple color emoji, segoe ui emoji,
      segoe ui symbol;
  }
  .archive-item:hover {
    color: #225a50;
    text-decoration: underline;
    text-underline-offset: 2px;
  }
}
</style>