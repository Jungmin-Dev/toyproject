<template>
  <v-container fluid fill-height >
    <v-layout
        align-center
        justify-center>
      <v-flex
          xs12
          sm8
          md4>
        <v-card
            class="elevation-12"
        >
          <v-toolbar
              color="light-green lighten-4"
              flat
              class="d-flex"
          >
            <v-img src='' max-height="50" contain></v-img>
            <v-toolbar-title class="title">Login</v-toolbar-title>
          </v-toolbar>
          <v-card-text>
            <v-form
                ref="loginForm"
                v-model="valid"
                @submit.prevent="loginEvent"
            >
              <v-text-field
                  label="아이디"
                  name="userId"
                  v-model="userId"
                  prepend-icon="mdi-account"
                  type="text"
                  @keyup.enter="loginEvent"
              ></v-text-field>
              <v-text-field
                  id="password"
                  label="패스워드"
                  name="password"
                  v-model="password"
                  prepend-icon="mdi-lock"
                  type="password"
                  @keyup.enter="loginEvent"
              ></v-text-field>
            </v-form>
            <v-card-actions>
              <v-btn
                  @click="loginEvent"
                  block
                  type="summit"
                  style="color:#fff;font-weight:bolder"
                  color="light-green lighten-2">
                Login
              </v-btn>
            </v-card-actions>
          </v-card-text>
        </v-card>
      </v-flex>
    </v-layout>
  </v-container>
</template>

<script>

</script>

<style scoped>
.title {
  color:#7CB342;
  font-weight:bolder

}
</style>
